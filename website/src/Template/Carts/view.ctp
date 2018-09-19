<!--<?php $this->Flash->render('message') ?>-->
<?php echo  $this->Form->create('Cart',array('url'=>array('controller'=>'carts', 'action'=>'update')));?>



<div class="container clearfix"  style="margin-top:20px;">
    <div class="card">
<?php $userid = $this->request->session()->read('Auth.User.id')?>
<div class="table-responsive">
<table class="table table-hover shopping-cart-wrap">
<thead class="text-muted">
<tr>
  <th scope="col">Il tuo evento</th>
  <th scope="col" width="150">Quantit&agrave;</th>
  <th scope="col" width="300">Prezzo</th>
</tr>
</thead>
<tbody>
<?php $total=0; $idEvent = 0; $count = 0; ?>
<?php foreach ($products as $product):?>
<tr>
	<td>
<figure class="media">
	<div class="img-wrap img-mobile-none" style="margin-right: 20px;">
	    <?php echo '<img class="img-thumbnail" style="width: 300px" src="'. $product->img .'">'; ?>
	</div>
	<figcaption class="media-body">
	    <?php    
            $idEvent = $product->id;
            $count = $product['count'];
        ?>
		<h4 class="title text-truncate"><?php echo $product['title'];?></h4>
		<p>
		    <strong>Luogo evento</strong><br/>
		    <?php echo $product['position'];?>
		</p>
        <p>
            <strong>Data e Ora</strong><br/>
            <?php echo $product['date'];?> - <?php echo $product->hour;?>
        </p>
	</figcaption>
</figure> 
	</td>
	<td> 
		<div class="col-sm-6" style="padding: 0;">
            <div class="mb-3">
                <?php echo $this->Form->hidden('product_id.',array('value'=>$product->id));?>
                <?php echo $this->Form->input('count.',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
            'class'=>'form-control form-control-sm', 'value'=>$product['count'])); ?>
            </div>
        </div>
	</td>
	<td> 
		<div class="price-wrap"> 
		    <?php $total = $total + ($product['count']*floatval($product['price']));?>
			<var class="price">EUR <?php echo $total;?></var><br/> 
			<small class="text-muted">EUR <?php echo floatval($product['price']);?> cad.</small> 
		</div> <!-- price-wrap .// -->
	</td>
	<?php endforeach;?>
</tr>

</tbody>
</table>
</div>
</div> <!-- card.// -->
</div>

<?php if ($idEvent != 0){?>
<div class="container clearfix"  style="margin-top:20px;">
    <div class="card">
    	<div class="card-body">
        	<div class="row">
                <div class="col-sm-12">
                    <div class="btn-group-custom">
                    	<?php echo $this->Form->submit('Aggiorna',array('class'=>'btn btn-outline-success','div'=>false));?>&nbsp;
                    	<?php echo $this->Html->link('x Elimina', ['controller' => 'Carts', 'action' => 'delete'], ['class' => 'btn btn-outline-danger']);?>
                    </div>
                    <div style="float: right;">
                        <?php echo $this->Html->link('Prosegui', ['controller' => 'Carts', 'action' => 'payment', $userid, $idEvent, $count], ['class' => 'btn btn-info btn-block']);}
                        ?>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<?php echo $this->Form->end();?>



