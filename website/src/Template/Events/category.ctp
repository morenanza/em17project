<div class="row" style="margin-top:50px;">
    
    <?php if(!empty($events)):?>
        <?php foreach($events as $event):?>
            <?php if($event->ticketsAvaible > $event->ticketsSell){ ?>
            <div class="col-md-4" style="text-align:center; margin-bottom:30px;">
                <?php 
                echo '<img src="'. $event->img .'" style="width:100%;">';
                ?>
                <?php echo $event->title;?><br/>
               <?php echo $event->price;?> €<br/>
               <?php echo $this->Html->link('Visualizza', ['action' => 'detail', $event->id], ['class' => 'btn btn-secondary'])?>
            </div>  
            <?php }?>
        <?php endforeach;?>
    <?php else:?>
        <td>Nessun evento disponibile per la categoria selezionata!</td>
    <?php endif;?>
</div>