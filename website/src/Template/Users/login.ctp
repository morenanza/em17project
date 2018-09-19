<?php $this->Flash->render('message') ?>
<?= $this->Form->create() ?>
<div class="container clearfix"  style="margin-top:20px;">
    <div class="row justify-content-center">
        <div class="col-md-4 card">
        	<div class="card-body">
            	<div class="row">
                    <h3>Accedi al tuo account</h3>
                    <div class="form-group row" style="margin-left:0px; margin-right:0px;">
                        <div class="col-md-12">
                            <fieldset>
                                <?= $this->Form->control('username', ['class' => 'form-control']) ?>
                                <?= $this->Form->control('password', ['class' => 'form-control']) ?>
                            </fieldset>
                            <p></p>
                       
                            <?= $this->Form->button(__('Login'), array('class'=>'btn btn-info')); ?>
                            <?= $this->Form->end() ?>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
