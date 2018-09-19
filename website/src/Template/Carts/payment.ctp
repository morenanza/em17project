<div class="container clearfix"  style="margin-top:20px;">
    <div class="card">
    	<div class="card-body">
        	<div class="row">
                <div class="col-md-6">
                    <fieldset>
                        <?php echo  $this->Form->create('Payment', array('url'=>array('controller'=>'carts', 'action'=>'check', $user->id, $event->id, $quantity)));?>
                        <legend><?= __('Dati di fatturazione') ?></legend>
                        <?= $this->Form->input('name', array('value'=>$user->name, 'class' => 'form-control')); ?>
                        <?= $this->Form->input('surname', array('value'=>$user->surname , 'class' => 'form-control')); ?>
                        <?= $this->Form->input('address', array('value'=>$user->address, 'class' => 'form-control')); ?>
                        <?= $this->Form->input('city', array('value'=>$user->city , 'class' => 'form-control')); ?>
                        <?= $this->Form->input('province', array('value'=>$user->province, 'class' => 'form-control')); ?>
                     
                    
                </div>
                <div class="col-md-6">
                    
                    
                        <legend><?= __('Dati di pagamento') ?></legend>
                        <?= $this->Form->input('customer', ['class' => 'form-control']) ?>
                        <?= $this->Form->input('card', ['class' => 'form-control']) ?>
                        <?= $this->Form->input('cvv', ['class' => 'form-control']) ?>
                        
                   </fieldset> 
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container clearfix"  style="margin-top:20px;">
    <div class="card">
    	<div class="card-body">
        	<div class="row">
                <div class="col-md-12 text-right">
                    <?= $this->Form->button(__('Acquista'), array('class'=>'btn btn-info')); ?>
                    <?= $this->Form->end() ?>
                </div>
            </div>
        </div>
    </div>
</div>
                

