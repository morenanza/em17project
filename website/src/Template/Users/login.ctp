
 <?php $this->Flash->render('message') ?>
<?= $this->Form->create() ?>
<div class="form-group row" style="margin-left:0px; margin-right:0px; margin-top:50px;">
    <div class="col-md-4"></div>
    <div class="col-md-4">
    <fieldset>
        <legend><?= __('Accedi') ?></legend>
        <?= $this->Form->control('username', ['class' => 'form-control']) ?>
        <?= $this->Form->control('password', ['class' => 'form-control']) ?>
    </fieldset>
    <p></p>
   
<?= $this->Form->button(__('Login'), array('class'=>'btn btn-secondary')); ?>
<?= $this->Form->end() ?>
    </div>

</div>