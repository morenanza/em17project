<?php
    namespace App\Controller;
    use App\Controller\AppController;
    use QRBarCode\QRBarCode;
    use Cake\Filesystem\Folder;
    use Cake\Filesystem\File;
    use RecursiveIteratorIterator;
    use ZipArchive;
    use RecursiveDirectoryIterator;
    use Cake\ORM\TableRegistry;

    class CartsController extends AppController
    {
        public function initialize()
    {
        parent::initialize();
        
        $this->loadComponent('RequestHandler');
        $this->loadComponent('Flash');
        $this->loadComponent('Auth');
    }
    
        public function add()
        {
            $this->autoRender = false;
            if ($this->request->is('post')) {
                if( empty($this->request->data['count']) )
                {
                   $this->Flash->error(__('Devi selezionare una quantità', ['key' => 'message']));
                   $this->redirect(['controller'=>'Events', 'action' => 'detail',$this->request->data['id']]);
                }else {
                    $message = $this->Carts->addProduct($this->request->data['id'], $this->request->session(), $this->request->data['count']);
                
                        if($message == 0){
                            //echo $this->Carts->getCount();
                        $this->redirect(['controller'=>'Carts', 'action' => 'view', 'Non puoi aggiungere al carrello pi첫 di un evento']);
                
                        }
                        else if ($message == 1)
                        {
                            $this->redirect(['controller'=>'Carts', 'action' => 'view', 'Evento aggiunto al carrello']);
                        }
                }
            }

        }
        
        public function delete() {
            unset($_SESSION['cart']);
            $this->redirect(['controller'=>'Carts', 'action' => 'view']);
        }
        
        public function view($message = null)
        {
            $this->Flash->success(__($message, ['key' => 'message']));
            $this->loadModel('Events');
            $carts = $this->Carts->readProduct($this->request->session());
            $products = array();
            if (null!=$carts) {
            foreach ($carts as $productId => $count) {
                $product = $this->Events->get($productId);
                $product['count'] = $count;
                $products[]=$product;
            }
        }
        
    $this->set(compact('products'));
        
        
    }
    
    public function update() {
    if ($this->request->is('post')) {
        if (!empty($this->request->data)) {
            $cart = array();
            foreach ($this->request->data['count'] as $index=>$count) {
                if ($count>0) {
                    $productId = $this->request->data['product_id'][$index];
                    $cart[$productId] = $count;
                }
            }
            $this->Carts->saveProduct($cart, $this->request->session());
        }
    }
    $this->redirect(array('action'=>'view'));
}

    public function payment($id = Null, $idEvent = Null, $count)
    {
        $this->loadModel('Users');
        $this->loadModel('Events');
        $user = $this->Users->get($id);
        $event = $this->Events->get($idEvent);
        $this->set('user', $user);
        $this->set('event', $event);
        $this->set('quantity', $count);
    }
    
    public function check($id, $idEvent, $count)
    {
         if (!empty($this->request->data)) {
             if(empty($this->request->data['customer']) || empty($this->request->data['card']) || empty($this->request->data['cvv'])) 
             {
                 $message = 'Compila i campi: Customer, Card e CVV';
                 $this->Flash->success(__($message, ['key' => 'message']));
                 
                
                 $this->redirect(array('action'=>'payment', $id, $idEvent, $count));
                 
             }else {
                if($this->request->data['card']%2 == 0)
                {
                    $this->loadModel('Events');
                    $event = $this->Events->get($idEvent);
                    $query = $this->Events->query();
                    $query->update()
                    ->set(['ticketsSell' => $event->ticketsSell + $count])
                    ->where(['id' => $idEvent])
                    ->execute();
                    
                    
                    $this->loadModel('Orders');
                    $query = $this->Orders->query();
                    $query->insert(['idCustomer', 'idEvent', 'quantity'])
                    ->values([
                        'idCustomer' => $id,
                        'idEvent' => $idEvent,
                        'quantity' => $count
                    ])
                    ->execute();
                    
                     $this->redirect(array('action'=>'generate', $id));
                } else 
                {
                    $this->redirect(array('action' => 'notvalid'));
                }
             }
         }
             else 
            {
                $this->redirect(array('action' => 'notvalid'));
            }
         
        
        
    }
    
    public function notvalid()
    {
        $this->Flash->success(__('Pagamento non andato a buon fine.', ['key' => 'message']));
    }
    
    public function generate($id)
    {
        require_once(ROOT .DS. "vendor" . DS  . "QRBarCode" . DS . "QRBarCode.php");
        $this->loadModel('Users');
        $user = $this->Users->get($id);
        $this->loadModel('Events');
        $carts = $this->Carts->readProduct($this->request->session());
        if (null!=$carts) {
            foreach ($carts as $productId => $count) {
                $product = $this->Events->get($productId);
                $product['count'] = $count;
            }
        }
        
        $text = $user->surname . $product->title;
        $path = WWW_ROOT . 'img' . DS . $text . DS;
        $folder = new Folder($path, true, 0755);
        
        
        for($i = 1; $i <= $product['count']; ++$i){
        
            $qr = new QRBarCode(); 
        
            $qr->text($text . $i);
        
            $qr->qrCode(350, $path . $text . $i . '.png');
            
        }
        $rootPath = realpath($path);

        
        $zip = new \ZipArchive();
        $zip->open($path . $text . '.zip', ZipArchive::CREATE | ZipArchive::OVERWRITE);
        
      
        $files = new RecursiveIteratorIterator(
            new RecursiveDirectoryIterator($rootPath),
            RecursiveIteratorIterator::LEAVES_ONLY
        );
        
        foreach ($files as $name => $file)
        {
            // Skip directories (they would be added automatically)
            if (!$file->isDir())
            {
                // Get real and relative path for current file
                $filePath = $file->getRealPath();
                $relativePath = substr($filePath, strlen($rootPath) + 1);
        
                // Add current file to archive
                $zip->addFile($filePath, $relativePath);
            }
        }
        
        // Zip archive will be created only after closing object
        $zip->close();
        $this->set('Zip_path', $text . '/' . $text . '.zip');
        unset($_SESSION['cart']);
    }
    
    
}

?>