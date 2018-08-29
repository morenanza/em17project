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
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="http://cmsblog.it/cakephp">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor03">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
          <?php if ($this->request->session()->read('Auth.User'))
          {
              echo $this->Html->link('Logout', ['controller' => 'Users', 'action' => 'logout']);
          }
          else 
          {
            echo $this->Html->link('Registrati', ['controller' => 'Users', 'action' => 'register']);
          }
          ?>
        
      </li>
      
      <li class="nav-item" style="margin-left: 15px;">
          <?php if ($this->request->session()->read('Auth.User'))
          {
          }
          else 
          {
            echo $this->Html->link('Login', ['controller' => 'Users', 'action' => 'login']);
          }
          ?>
        
      </li>
      
      <li class="nav-item" style="margin-left: 15px;">
          <?php if($this->request->session()->read('Auth.User')){
            echo $this->Html->link('Carrello', ['controller' => 'Carts', 'action' => 'view']);}
          ?>
        
      </li>
      
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
    <?= $this->Flash->render() ?>
    <div class="container clearfix">
        <?= $this->fetch('content') ?>
    </div>
    <footer>
        <?php echo $this->Html->script('bootstrap.min') ?>
    <?php echo $this->Html->script('jquery-3.3.1.min') ?>
    </footer>
</body>
</html>
