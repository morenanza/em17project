<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;
use Cake\ORM\TableRegistry;
use Cake\Network\Session;
use Cake\Core\Configure;

class CartsTable extends Table
{

/**
 * Initialize method
 *
 * @param array $config The configuration for the Table.
 * @return void
 */
public function initialize(array $config)
{
    parent::initialize($config);

    $this->setTable('carts');      
}

/*
 * add a product to cart
 */
public function addProduct($id, $session) {
    $allEvents = $this->readProduct($session);
    if($allEvents != null) {
        return 0;
    } else {
        
        $allEvents[$id] = 1;
        $this->saveProduct($allEvents, $session);
        return 1;
        
    }
}

/*
 * get total count of products
 */
public function getCount() {
    $allEvents = $this->readProduct();

    if (count($allEvents)<1) {
        return 0;
    }

    $count = 0;
    foreach ($allEvents as $event) {
        $count=$count+$product;
    }

    return $count;
}

/*
 * save data to session
 */
public function saveProduct($data, $session) {
    
    return $session->write('cart',$data);
}

/*
 * read cart data from session
 */
public function readProduct($session) {
    //$session = new Session();
    return $session->read('cart');
}
}
?>