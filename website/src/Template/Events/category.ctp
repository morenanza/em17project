<!-- START BANNER -->
 <div id="carousel" class="carousel slide carousel-fade" data-ride="carousel" data-interval="6000">
        
        <ol class="carousel-indicators">
            <li data-target="#carousel" data-slide-to="0" class="active"></li>
            <li data-target="#carousel" data-slide-to="1"></li>
            <li data-target="#carousel" data-slide-to="2"></li>
        </ol>
        
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                     <picture>
                      <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-2000-1.jpg" media="(min-width: 1400px)">
                      <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-1400-1.jpg" media="(min-width: 769px)">
                       <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-800-1.jpg" media="(min-width: 577px)">
                      <img srcset="http://cmsblog.it/cakephp/webroot/img/slide-600-1.jpg" alt="responsive image" class="d-block img-fluid">
                    </picture>

                    <div class="carousel-caption">
                        <div>
                            <h1>EM17 Concert</h1>
                            <p>La tua piattaforma di concerti, mostre, spettacoli, teatri e tanti altri eventi</p>
                        </div>
                    </div>
            </div>
            
            <div class="carousel-item">
                     <picture>
                      <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-2000-2.jpg" media="(min-width: 1400px)">
                      <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-1400-2.jpg" media="(min-width: 769px)">
                       <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-800-2.jpg" media="(min-width: 577px)">
                      <img srcset="http://cmsblog.it/cakephp/webroot/img/slide-600-2.jpg" alt="responsive image" class="d-block img-fluid">
                    </picture>

                    <div class="carousel-caption justify-content-center align-items-center">
                        <div>
                            <h2>Every project begins with a sketch</h2>
                            <p>We work as an extension of your business to explore solutions</p>
                            <span class="btn btn-sm btn-outline-secondary">Our Process</span>
                        </div>
                    </div>
            </div>
            <div class="carousel-item">
                     <picture>
                      <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-2000-3.jpg" media="(min-width: 1400px)">
                      <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-1400-3.jpg" media="(min-width: 769px)">
                       <source srcset="http://cmsblog.it/cakephp/webroot/img/slide-800-3.jpg" media="(min-width: 577px)">
                      <img srcset="http://cmsblog.it/cakephp/webroot/img/slide-600-3.jpg" alt="responsive image" class="d-block img-fluid">
                    </picture>

                    <div class="carousel-caption justify-content-center align-items-center">
                        <div>
                            <h2>Performance Optimization</h2>
                            <p>We monitor and optimize your site's long-term performance</p>
                            <span class="btn btn-sm btn-secondary">Learn How</span>
                        </div>
                    </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
        
    </div>
<!-- END BANNER -->

<div class="container clearfix">
<div class="row" style="margin-top:50px;">
    
    <?php if(!empty($events)):?>
        <?php foreach($events as $event):?>
            <?php if($event->ticketsAvaible > $event->ticketsSell){ ?>
            <div class="col-md-4" style="margin-bottom:30px;">
                <!--Card-->
                <div class="card">
                <!--Card image-->
                <?php 
                echo '<img class="img-fluid" src="'. $event->img .'" >';
                ?>
                <!--Card content-->
                <div class="card-body">
                    <!--Title-->
                    <h4 class="card-title"><?php echo $event->title;?></h4>
                    <!--Text-->
                    <p class="card-text">
                        <?php echo substr($event->description, 0, 100);?><br/>
                        <strong>Luogo: </strong><?php echo $event->position;?><br/>
                        <strong>Prezzo: </strong><?php echo $event->price;?> &euro;</p>
                    <?php echo $this->Html->link('Maggiori Informazioni', ['action' => 'detail', $event->id], ['class' => 'btn btn-info'])?>
                    </div>
                </div>
                <!--/.Card-->
            </div>  
            <?php }?>
        <?php endforeach;?>
    <?php else:?>
        <td>Nessun evento disponibile per la categoria selezionata!</td>
    <?php endif;?>
</div>
</div>

		
            
                
