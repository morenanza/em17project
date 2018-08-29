<?php $this->Flash->render('message') ?>
<?php echo  $this->Form->create('Cart',array('url'=>array('controller'=>'carts', 'action'=>'update')));?>
<div class="row">
    <div class="col-lg-12">
        <?php $userid = $this->request->session()->read('Auth.User.id')?>
        <table class="table">
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <?php $total=0;?>
        <?php foreach ($products as $product):?>
        <tr>
            <td><?php echo $product['title'];?></td>
            <td>tk. <?php echo $product['price'];?>
            </td>
            <td><div class="col-xs-3">
                <?php echo $this->Form->hidden('product_id.',array('value'=>$product->id));?>
                <?php echo $this->Form->input('count.',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                'class'=>'form-control input-sm', 'value'=>$product['count']));?>
            </div></td>
            <td>tk. <?php echo $product['count']*$product['price']; ?>
            </td>
            <td><?php echo $this->Html->link('Elimina', ['controller' => 'Carts', 'action' => 'delete'], ['class' => 'btn btn-primary']);?></td>
        </tr>
            <?php $total = $total + ($product['count']*$product['price']);?>
            <?php endforeach;?>

        <tr class="success">
            <td colspan=3></td>
            <td>tk. <?php echo $total;?>
            <td colspan=1></td>
            </td>
        </tr>
        </tbody>
    </table>

    <p class="text-right">
        <?php echo $this->Form->submit('Update',array('class'=>'btn btn-warning','div'=>false));?>
       <?php echo $this->Html->link('Prosegui', ['controller' => 'Carts', 'action' => 'payment', $userid], ['class' => 'btn btn-primary']);?>
    </p>

          </div>
      </div>
<?php echo $this->Form->end();?>