<div class="row">
    <div class="col-md-4">
        <?php 
            echo '<img src="'. $event->img .'" style="width:100%; height:400px">';
        ?>
    </div>
    <div class="col-md-8">
        <h4>Titolo:</h4><?php echo $event->title;?><br/>
        <h4>Costo biglietto:</h4><?php echo $event->price;?><br/>
        <h4>Descrizione:</h4><?php echo $event->description;?><br/>
        
        
        <?php 
        if ($this->request->session()->read('Auth.User.id')) {
            if ( $this->request->session()->read('cart') != null){
                echo $this->Form->input('count.',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                'class'=>'form-control input-sm', 'value' => '1'));
                echo $this->Form->button(__('Aggiungi al carrello'), array('class' => 'btn btn-primary')); 
            }else {
                echo $this->Form->create('Cart', ['id'=>'add-form', 'url' => ['controller'=>'Carts', 'action' => 'add']]); ?>
                <?php echo $this->Form->hidden('id',array('value'=>$event->id))?>
                <?php echo $this->Form->input('count.',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                'class'=>'form-control input-sm', 'value' => '1')); ?>
                <?= $this->Form->button(__('Aggiungi al carrello'), array('class' => 'btn btn-primary')); ?>
                <?= $this->Form->end(); }}
        else 
        {
            
            echo $this->Form->button(__('Aggiungi al carrello'), array('class' => 'btn btn-primary')); 
        }?>
        
        
    </div>
</div>