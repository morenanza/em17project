<?php $this->Flash->render('message') ?>
<?php echo  $this->Form->create('Cart',array('url'=>array('controller'=>'carts', 'action'=>'update')));?>
<div class="row" style="margin-top:50px;">
    <div class="col-lg-12">
        <h5>Riepilogo ordine</h5><br/>
        <?php $userid = $this->request->session()->read('Auth.User.id')?>
        <table class="table table-responsive-sm">
        <thead>
        <tr>
            <th>Evento</th>
            <th>Luogo</th>
            <th>Data</th>
            <th>Costo</th>
            <th>Quantità</th>
            <!--<th>Totale</th>-->
            <th></th>
        </tr>
        </thead>
        <tbody>
        <?php $total=0;
        $idEvent = 0;
        $count = 0;
        ?>
        <?php foreach ($products as $product):?>
        <tr>
            <?php    
            $idEvent = $product->id;
            $count = $product['count'];
            
                    
            ?>
            <td><?php echo $product['title'];?></td>
            <td><?php echo $product['position'];?>
            <td><?php echo $product['date'];?>
            </td>
            </td>
            <td>€ <?php echo $product['price'];?>
            </td>
            <td><div class="col-xs-3">
                <?php echo $this->Form->hidden('product_id.',array('value'=>$product->id));?>
                <?php echo $this->Form->input('count.',array('type'=>'number', 'label'=>false, 'min' => '1', 'max' => '5',
                'class'=>'form-control input-sm', 'value'=>$product['count']));?>
            </div></td>
            <!--<td>€ <?php //echo $product['count']*$product['price']; ?>
            </td>-->
            <td></td>
        </tr>
        
            <?php $total = $total + ($product['count']*$product['price']);?>
            <?php endforeach;?>

        <tr class="success">
            <td colspan=4></td>
            
            <td><strong>Totale </strong><br/>€ <?php echo $total;?>
            <td colspan=1></td>
            </td>
        </tr>
        </tbody>
    </table>

    <p class="text-right">
        <?php if ($idEvent != 0){?>
        
        <div class="btn-group"><?php echo $this->Html->link('Elimina', ['controller' => 'Carts', 'action' => 'delete'], ['class' => 'btn btn-secondary']);?> <p>&nbsp;&nbsp;</p>
            <?php echo $this->Form->submit('Aggiorna',array('class'=>'btn btn-secondary','div'=>false));?> </div> 
            <div style="float: right;">
            <?php echo $this->Html->link('Prosegui', ['controller' => 'Carts', 'action' => 'payment', $userid, $idEvent, $count], ['class' => 'btn btn-secondary btn-block']);}?></div>
       
    </p>

          </div>
      </div>
<?php echo $this->Form->end();?>