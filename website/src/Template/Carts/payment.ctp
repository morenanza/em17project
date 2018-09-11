<div class="row" style="margin-left:0px; margin-right:0px; margin-top:50px;">

<div class="col-md-6">
   <fieldset>
        <legend><?= __('Dati di fatturazione') ?></legend>
        <?= $this->Form->input('name', array('value'=>$user->name, 'class' => 'form-control')); ?>
        <?= $this->Form->input('surname', array('value'=>$user->surname , 'class' => 'form-control')); ?>
        <?= $this->Form->input('address', array('value'=>$user->address, 'class' => 'form-control')); ?>
        <?= $this->Form->input('city', array('value'=>$user->city , 'class' => 'form-control')); ?>
        <?= $this->Form->input('province', array('value'=>$user->province, 'class' => 'form-control')); ?>
     
   </fieldset> 
</div>
<div class="col-md-6">
    <?php echo  $this->Form->create('Payment', array('url'=>array('controller'=>'carts', 'action'=>'check', $user->id, $event->id, $quantity)));?>
    <fieldset>
        <legend><?= __('Dati di pagamento') ?></legend>
        <?= $this->Form->input('customer', ['class' => 'form-control']) ?>
        <?= $this->Form->input('card', ['class' => 'form-control']) ?>
        <?= $this->Form->input('cvv', ['class' => 'form-control']) ?>
        
   </fieldset> 
   </div>
   
   </div>
   <div class="row" style="float:right;">
   <?= $this->Form->button(__('Acquista'), array('class'=>'btn btn-secondary')); ?>
        <?= $this->Form->end() ?>
   
    

</div>