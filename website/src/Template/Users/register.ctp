<!-- src/Template/Users/add.ctp -->


    <?= $this->Form->create($user) ?>
    <div class="form-group row" style="margin-left:0px; margin-right:0px; margin-top:50px;">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <fieldset>
            <legend><?= __('Registrati') ?></legend>
            <?= $this->Form->control('username', ['class' => 'form-control']) ?>
            <?= $this->Form->control('password', ['class' => 'form-control']) ?>
            <?= $this->Form->control('email', ['class' => 'form-control']) ?>
            <?= $this->Form->control('name', ['class' => 'form-control']) ?>
            <?= $this->Form->control('surname', ['class' => 'form-control']) ?>
            <?= $this->Form->control('address', ['class' => 'form-control']) ?>
            <?= $this->Form->control('cap', ['class' => 'form-control']) ?>
            <?= $this->Form->control('city', ['class' => 'form-control']) ?>
            <?= $this->Form->control('province', ['class' => 'form-control']) ?>
            <?= $this->Form->control('date', ['class' => 'form-control']) ?>
        </fieldset>
        <p></p>
        <?= $this->Form->button(__('Registrati'), array('class'=>'btn btn-secondary')); ?>
        <?= $this->Form->end() ?>
</div>
</div>