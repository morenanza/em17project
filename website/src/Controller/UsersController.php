<?php namespace App\Controller;

use App\Controller\AppController;
use Cake\Event\Event;

class UsersController extends AppController
{
    public function initialize()
    {
        parent::initialize();

        $this->loadComponent('RequestHandler');
        $this->loadComponent('Flash');
        $this->loadComponent('Auth', [
            'loginRedirect' => [
                'controller' => 'Events',
                'action' => 'index'
            ],
            'logoutRedirect' => [
                'controller' => 'Events',
                'action' => 'index',
                'home'
            ]
        ]);
    }



    public function beforeFilter(Event $event)
    {
        parent::beforeFilter($event);
        $this->Auth->allow('register');
        $this->Auth->allow('view');
        
       
    }

    public function register()
    {
        $user = $this->Users->newEntity();
        if ($this->request->is('post')) {
            if($this->Users->find()->where(['username' => $this->request->data['username']])->count() >= 1 && $this->Users->find()->where(['email' => $this->request->data['email']])->count() >= 1)
            {
                $this->Flash->error(__('Username e Email già esistenti!'));
                return $this->redirect(['action' => 'register']);
            }
            if($this->Users->find()->where(['username' => $this->request->data['username']])->count() >= 1)
            {
                $this->Flash->error(__('Username già esistente!'));
                return $this->redirect(['action' => 'register']);
            }
            if($this->Users->find()->where(['email' => $this->request->data['email']])->count() >= 1)
            {
                $this->Flash->error(__('Email già esistente!'));
                return $this->redirect(['action' => 'register']);
            }
            // Prior to 3.4.0 $this->request->data() was used.
            $user = $this->Users->patchEntity($user, $this->request->getData());
            if ($this->Users->save($user)) {
                $this->Flash->success(__('Registrazione andata a buon fine. Effettua il login.', ['key' => 'message']));
                return $this->redirect(['action' => 'login']);
            }
            $this->Flash->error(__('Registrazione fallita.'));
        }
        $this->set('user', $user);
    }
    
    public function login()
    {
        if ($this->request->is('post')) {
            $user = $this->Auth->identify();
            if ($user) {
                $this->Auth->setUser($user);
                return $this->redirect($this->Auth->redirectUrl());
            }
            $this->Flash->error(__('Username o password non valida. Riprova!'));
        }
    }

    public function logout()
    {
        unset($_SESSION['cart']);
        return $this->redirect($this->Auth->logout());
    }
    
}
?>