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

$cakeDescription = 'CakePHP: the rapid development php framework';
?>
<!DOCTYPE html>
<html>
<head>
    <?= $this->Html->charset() ?>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        <?= $cakeDescription ?>:
        <?= $this->fetch('title') ?>
    </title>
    <?= $this->Html->meta('icon') ?>

    <?php echo $this->Html->css('bootstrap.min') ?>
    

    <?= $this->fetch('meta') ?>
    <?= $this->fetch('css') ?>
    <?= $this->fetch('script') ?>
</head>
<body>
    
<nav class="navbar navbar-expand-md navbar-light justify-content-end">
    <ul class="navbar-nav">
        <li class="nav-item" style="margin-left: 15px; display: inline;">
        <?php 
            if ($this->request->session()->read('Auth.User')){
                echo 'Benvenuto '. $this->request->session()->read('Auth.User.name') . '! ';
            }
            else{
                echo $this->Html->link('Accedi', ['controller' => 'Users', 'action' => 'login']);
                
            }
        ?>
        </li>
        <li class="nav-item" style="margin-left: 15px; display: inline;">
          
        <?php 
            if ($this->request->session()->read('Auth.User')){
                echo $this->Html->link('Logout', ['controller' => 'Users', 'action' => 'logout']);
            }
            else{
                echo $this->Html->link('Registrati', ['controller' => 'Users', 'action' => 'register']);
            }
        ?>
    </li>
      
    
    <li class="nav-item" style="margin-left: 15px; display: inline;">
            <?php 
                if($this->request->session()->read('Auth.User')){
                    echo $this->Html->link('Carrello', ['controller' => 'Carts', 'action' => 'view']);
                }
            ?>
    </li> 
</ul>
</nav>

<nav class="navbar navbar-expand-md bg-light navbar-light">
  <a class="navbar-brand" href="http://cmsblog.it/cakephp/">EM '17</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#prova">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="prova">
    <ul class="navbar-nav">
      <li class="nav-item">
        <?php
          echo $this->Html->link('Concerti', ['controller' => 'Events', 'action' => 'category', 'Concerto'], array('class' => 'nav-link'));
          ?>
      </li>
      <li class="nav-item">
        <?php
          echo $this->Html->link('Mostre', ['controller' => 'Events', 'action' => 'category', 'Mostra'], array('class' => 'nav-link'));
          ?>
      </li>
      <li class="nav-item">
        <?php
          echo $this->Html->link('Spettacoli', ['controller' => 'Events', 'action' => 'category', 'Spettacolo'], array('class' => 'nav-link'));
          ?>
      </li>
      <li class="nav-item">
        <?php
          echo $this->Html->link('Teatro', ['controller' => 'Events', 'action' => 'category', 'Teatro'], array('class' => 'nav-link'));
          ?>
      </li> 
    </ul>
  </div>  
</nav>


    <?= $this->Flash->render() ?>
    <div class="container clearfix">
        <?= $this->fetch('content') ?>
    </div>
    <footer>
        <?php echo $this->Html->script('bootstrap.min') ?>
    <?php echo $this->Html->script('jquery-3.3.1.min') ?>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </footer>
</body>
</html>
