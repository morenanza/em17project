<?php /*echo $this->Html->link('Logout', ['controller' => 'Users', 'action' => 'logout'], ['class' => 'btn btn-primary'])?>

<?php echo $this->Html->link('Login', ['controller' => 'Users', 'action' => 'login'], ['class' => 'btn btn-primary'])*/?>
<div class="row">
    
    <?php if(!empty($events)):?>
        <?php foreach($events as $event):?>
            <div class="col-md-4">
                <?php 
                echo '<img src="'. $event->img .'" style="width:100%;">';
                ?>
                <?php echo $event->title;?><br/>
               <?php echo $event->price;?><br/>
               <?php echo $this->Html->link('Visualizza', ['action' => 'detail', $event->id], ['class' => 'btn btn-primary'])?>
            </div>   
        <?php endforeach;?>
    <?php else:?>
        <td>No record found!</td>
    <?php endif;?>
</div>