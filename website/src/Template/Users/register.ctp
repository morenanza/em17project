<?= $this->Form->create($user) ?>
<div class="container clearfix"  style="margin-top:20px;">
    <div class="row justify-content-center">
        <div class="col-md-8 card">
        	<div class="card-body">
                    <h3>Registra un nuovo account</h3>
                    <div class="form-group row" style="margin-left:0px; margin-right:0px;">
                        <div class="col-md-6">
                        <fieldset>
                            <?= $this->Form->control('name', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('surname', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('address', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('cap', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('city', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('province', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('date', ['class' => 'form-control']) ?>
                        </div>
                        <div class="col-md-6">
                            <?= $this->Form->control('username', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('password', ['class' => 'form-control']) ?>
                            <?= $this->Form->control('email', ['class' => 'form-control']) ?>
                        </fieldset>
                        <p></p>
                        <?= $this->Form->button(__('Registrati'), array('class'=>'btn btn-info')); ?>
                        <?= $this->Form->end() ?>
                        </div>
                </div>
            </div>
        </div>
    </div>
</div>