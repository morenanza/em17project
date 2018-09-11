<div class="row" style="margin-top:50px;">
    <div class="col-md-4">
        <?php 
            echo '<img src="'. $event->img .'" style="width:100%; height:400px">';
        ?>
    </div>
    <div class="col-md-6">
        <h4><strong><?php echo $event->title;?></strong><br/></h4>
        <strong>Descrizione:  </strong><?php echo $event->description;?><br/>
        <strong>Luogo:  </strong><?php echo $event->position;?><br/>
        <strong>Città:  </strong><?php echo $event->city;?><br/>
        <strong>Data:  </strong><?php echo $event->date;?><br/>
        <strong>Ora:  </strong><?php echo $event->hour;?><br/>
        <strong>Costo biglietto:  </strong><?php echo $event->price;?><br/>
        <strong>Biglietti disponibili:  </strong><?php echo $event->ticketsAvaible - $event->ticketsSell;?><br/>
        
        <?php 
        if ($this->request->session()->read('Auth.User')) {
            if ( $this->request->session()->read('cart') != null){?>
           
            <strong>Quantità: </strong>
                <?php echo $this->Form->input('count.',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                'class'=>'form-control input-sm', 'value' => '1'));?><p></p>
                <?php
                echo $this->Form->button(__('Aggiungi al carrello'), array('class' => 'btn btn-secondary disabled')); 
            }else {
                echo $this->Form->create('Cart', ['id'=>'add-form', 'url' => ['controller'=>'Carts', 'action' => 'add']]); ?>
                <?php echo $this->Form->hidden('id',array('value'=>$event->id))?>
                
                <strong>Quantità: </strong>
                <?php echo $this->Form->input('count',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                'class'=>'form-control input-sm')); ?> <p></p>
                <?= $this->Form->button(__('Aggiungi al carrello'), array('class' => 'btn btn-secondary')); ?>
                <?= $this->Form->end(); }}
        else 
        {?>
        
        <strong>Quantità: </strong><?php
            echo $this->Form->input('count',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                'class'=>'form-control input-sm'));?><p></p><?php
            echo $this->Form->button(__('Aggiungi al carrello'), array('class' => 'btn btn-secondary disabled')); 
        }?>
        
        
    </div>
</div>