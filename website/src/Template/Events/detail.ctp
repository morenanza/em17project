<div class="container clearfix">
    <div class="row pa10lr" style="margin-top:20px;">
        
        
        <article class="card card-product">
        	<div class="card-body">
        	<div class="row">
        		<aside class="col-md-4">
        		    <h4 class="title" style="margin-bottom: 20px;"><?php echo $event->title;?></h4>
        			<div class="img-wrap">
        			    <?php echo '<img class="img-thumbnail rounded float-left" src="'. $event->img .'">'; ?>
        			</div>
                    
        		</aside> <!-- col.// -->
        		<article class="col-md-5">
        			
        				<p> <?php echo $event->description;?> </p>
        				<p>
        				    <strong>Luogo evento</strong>&nbsp;&nbsp;&nbsp;<?php echo $event->position;?>, <?php echo $event->city;?>
        				</p>
        				<p>
        				    <strong>Data e Ora</strong>&nbsp;&nbsp;&nbsp;<?php echo $event->date;?> - <?php echo $event->hour;?>
        				</p>
        				<p>
        				    <strong>Biglietti disponibili</strong>&nbsp;&nbsp;&nbsp;<?php echo $event->ticketsAvaible - $event->ticketsSell;?>
        				</p>
        			
        		</article> <!-- col.// -->
        		<aside class="col-md-3 border-left-card-event-detail">
        			<div class="action-wrap">
        				<div class="price-wrap h4">
        				    Prezzo
        				    <span class="price" style="color: #00b900; font-weight: 800;"> <?php echo $event->price;?> &euro; </span>
        			</div> <!-- info-price-detail // -->
        			<?php 
                    if ($this->request->session()->read('Auth.User')) {
                        if ( $this->request->session()->read('cart') != null){?>
                       
                        <strong>Quantità: </strong>
                        <div class="col-sm-6" style="padding: 0;">
                            <div class="mb-3">
                                <?php echo $this->Form->input('count',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                            'class'=>'form-control form-control-sm')); ?>
                            </div>
                        </div>
                            <?php
                            echo $this->Form->button(__('Carrello pieno'), array('class' => 'btn btn-secondary disabled')); 
                        }else {
                            echo $this->Form->create('Cart', ['id'=>'add-form', 'url' => ['controller'=>'Carts', 'action' => 'add']]); ?>
                            <?php echo $this->Form->hidden('id',array('value'=>$event->id))?>
                            
                            <strong>Quantità: </strong>
                            <div class="col-sm-6" style="padding: 0;">
                                <div class="mb-3">
                                    <?php echo $this->Form->input('count',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                                'class'=>'form-control form-control-sm')); ?>
                                </div>
                            </div>
                            
                            <?= $this->Form->button(__('Aggiungi al carrello'), array('class' => 'btn btn-info')); ?>
                            <?= $this->Form->end(); }}
                    else 
                    {?>
                    
                    <strong>Quantità: </strong>
                    <div class="col-sm-6" style="padding: 0;">
                        <div class="mb-3">
                            <?php echo $this->Form->input('count',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                        'class'=>'form-control form-control-sm')); ?>
                        </div>
                    </div>
                    
                    <?php
                    echo $this->Html->link('Effettua il login', ['controller' => 'Users', 'action' => 'login'], ['class' => 'btn btn-info']);
                    }?>
        			</div> <!-- action-wrap.// -->
        		</aside> <!-- col.// -->
        	</div> <!-- row.// -->
        	</div> <!-- card-body .// -->
        </article> <!-- product-list.// -->

        </div>
    </div>
</div>