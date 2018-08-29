<?php namespace App\Model\Table;

use Cake\ORM\Table;
use Cake\Validation\Validator;

class UsersTable extends Table
{

    public function validationDefault(Validator $validator)
    {
        return $validator
            ->notEmpty('username', 'A username is required')
            ->notEmpty('password', 'A password is required')
            ->notEmpty('email', 'An email is required')
            ->notEmpty('name', 'A name is required')
            ->notEmpty('surname', 'A surname is required')
            ->notEmpty('address', 'An address is required')
            ->notEmpty('cap', 'A cap code is required')
            ->notEmpty('city', 'A city is required')
            ->notEmpty('date', 'A date is required')
            ->notEmpty('province', 'A province is required');
    }

}

?>