<?php
/**
 * CakePHP(tm) : Rapid Development Framework (https://cakephp.org)
 * Copyright (c) Cake Software Foundation, Inc. (https://cakefoundation.org)
 *
 * Licensed under The MIT License
 * For full copyright and license information, please see the LICENSE.txt
 * Redistributions of files must retain the above copyright notice.
 *
 * @copyright     Copyright (c) Cake Software Foundation, Inc. (https://cakefoundation.org)
 * @link          https://cakephp.org CakePHP(tm) Project
 * @since         0.10.0
 * @license       https://opensource.org/licenses/mit-license.php MIT License
 */

$cakeDescription = 'EM17 - Software Engineering Project 2018';
?>
<!DOCTYPE html>
<html>
<head>
    <?= $this->Html->charset() ?>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        <?= $cakeDescription ?>
    </title>
    <?= $this->Html->meta('icon') ?>
    <!-- CSS Custom -->
    <?php echo $this->Html->css('custom') ?>
    
    <!-- CSS Bootstrap 4 -->
    <?php echo $this->Html->css('bootstrap.min') ?>
    

    <?= $this->fetch('meta') ?>
    <?= $this->fetch('css') ?>
    <?= $this->fetch('script') ?>
    
    <!-- Icone SVG -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>
<body>
<!-- START TOP BAR -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark justify-content-end">
    <?php 
            if ($this->request->session()->read('Auth.User')){
                echo '<span style="color: #17a2b8; font-weight: 800;">Benvenuto/a '. $this->request->session()->read('Auth.User.name') . '!&nbsp;&nbsp;&nbsp;</span>';
            }
    ?>
    <ul class="navbar-nav" style="-ms-flex-direction: row;
    flex-direction: row !important;">
            <?php 
                if ($this->request->session()->read('Auth.User')){
                    echo '<li class="nav-item dropdown">
                            <a class="btn btn-outline-info btn-sm dropdown-toggle" data-toggle="dropdown" href="#">Impostazioni</a>
                            <div class="dropdown-menu" role="menu">'
                             . $this->Html->link('Logout', ['controller' => 'Users', 'action' => 'logout'], ['class' => 'dropdown-item']) . '
                            </div>
                        </li>';
                }
                else{
                    echo $this->Html->link('Accedi', ['controller' => 'Users', 'action' => 'login'], ['class' => 'btn btn-outline-info btn-sm']);
                }
            ?>
          
        
        <li class="nav-item" style="margin-left: 15px; display: inline;">
                <?php 
                    if($this->request->session()->read('Auth.User')){
                        echo $this->Html->link('', ['controller' => 'Carts', 'action' => 'view'], ['class' => 'btn-cart-icon fas fa-shopping-cart']);
                    }
                    else
                    {
                        echo $this->Html->link('Registrati', ['controller' => 'Users', 'action' => 'register'], ['class' => 'btn btn-outline-info btn-sm']);
                    }
                ?>
        </li> 
    </ul>
</nav>
<!-- END TOP BAR -->

<!-- START NAVBAR -->
<nav class="navbar navbar-expand-md bg-navbar-menu navbar-light">
  <a class="navbar-brand" href="http://cmsblog.it/cakephp/"><img src="http://cmsblog.it/cakephp/webroot/img/logo.png" alt="Logo EM17"/></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#prova">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-center" id="prova">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link hvr-underline-from-center" href="http://cmsblog.it/cakephp/">Home</a>
      </li>
      <li class="nav-item">
        <?php
          echo $this->Html->link('Concerti', ['controller' => 'Events', 'action' => 'category', 'Concerto'], array('class' => 'nav-link hvr-underline-from-center'));
          ?>
      </li>
      <li class="nav-item">
        <?php
          echo $this->Html->link('Mostre', ['controller' => 'Events', 'action' => 'category', 'Mostra'], array('class' => 'nav-link hvr-underline-from-center'));
          ?>
      </li>
      <li class="nav-item">
        <?php
          echo $this->Html->link('Spettacoli', ['controller' => 'Events', 'action' => 'category', 'Spettacolo'], array('class' => 'nav-link hvr-underline-from-center'));
          ?>
      </li>
      <li class="nav-item">
        <?php
          echo $this->Html->link('Teatro', ['controller' => 'Events', 'action' => 'category', 'Teatro'], array('class' => 'nav-link hvr-underline-from-center'));
          ?>
      </li> 
    </ul>
  </div>  
</nav>
<!-- END NAVBAR -->

    <?= $this->Flash->render() ?>
    
        <?= $this->fetch('content') ?>
        
    

   <footer class="footer" style="margin-top: 20px;">
    <div class="container bottom_border">
        <div class="row">
            <div class=" col-sm-4 col-md col-sm-4  col-12 col">
                <h5 class="headin5_amrc col_white_amrc pt2">Informazioni</h5>
                <p class="mb10">Sito web per la visualizzazione di eventi e l'acquisto di biglietti con generazione di codici QR.<br/>Progetto di Ingegneria del Software 2017-2018</p>
                <p><i class="fa fa-location-arrow"></i> 9878/25 sec 9 rohini 35 </p>
                <p><i class="fa fa-phone"></i>  +91-9999878398  </p>
                <p><i class="fa fa fa-envelope"></i> info@example.com  </p>
            </div>
        
        
            <div class=" col-sm-4 col-md  col-6 col">
                <h5 class="headin5_amrc col_white_amrc pt2">Menu</h5>
                <!--headin5_amrc-->
                <ul class="footer_ul_amrc">
                    <li><a href="#">Home</a></li>
                    <li>
                        <?php
                            echo $this->Html->link('Concerti', ['controller' => 'Events', 'action' => 'category', 'Concerto']);
                        ?>
                    </li>
                    <li>
                        <?php
                            echo $this->Html->link('Mostre', ['controller' => 'Events', 'action' => 'category', 'Mostra']);
                        ?>
                    </li>
                    <li>
                        <?php
                            echo $this->Html->link('Spettacoli', ['controller' => 'Events', 'action' => 'category', 'Spettacolo']);
                        ?>
                    </li>
                    <li>
                        <?php
                            echo $this->Html->link('Teatro', ['controller' => 'Events', 'action' => 'category', 'Teatro']);
                        ?>
                    </li>
                </ul>
            </div>
        
        
            <div class=" col-sm-4 col-md  col-6 col">
                <h5 class="headin5_amrc col_white_amrc pt2">Links Utili</h5>
                <!--headin5_amrc-->
                <ul class="footer_ul_amrc">
                    <li><a href="#">Accedi</a></li>
                    <li><a href="#">Registrati</a></li>
                    <li><a href="#">Condizioni</a></li>
                    <li><a href="#">Reso</a></li>
                    <li><a href="#">Contatti</a></li>
                </ul>
            </div>
        
        
            <div class=" col-sm-4 col-md  col-12 col">
                <h5 class="headin5_amrc col_white_amrc pt2">Notizie da Twitter</h5>
                <!--headin5_amrc ends here-->
        
                <ul class="footer_ul2_amrc">
                    <li><a href="#"><i class="fab fa-twitter fleft padding-right"></i> </a><p>Lorem Ipsum is simply dummy text of the printing...<a href="#">https://www.lipsum.com/</a></p></li>
                    <li><a href="#"><i class="fab fa-twitter fleft padding-right"></i> </a><p>Lorem Ipsum is simply dummy text of the printing...<a href="#">https://www.lipsum.com/</a></p></li>
                    <li><a href="#"><i class="fab fa-twitter fleft padding-right"></i> </a><p>Lorem Ipsum is simply dummy text of the printing...<a href="#">https://www.lipsum.com/</a></p></li>
                </ul>
            </div>
        </div>
    </div>
        
        
    <div class="container">
        <p class="text-center">Copyright &copy; 2017-2018 | Progetto di Ingegneria del Software</p>
    </div>
        
        
    <?php echo $this->Html->script('bootstrap.min') ?>
    <?php echo $this->Html->script('jquery-3.3.1.min') ?>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <?php echo $this->Html->script('custom') ?>
</footer>
    
</body>
</html>
