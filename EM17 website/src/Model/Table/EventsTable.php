<?php 

namespace App\Model\Table;

use Cake\ORM\Table;

use Cake\Event\Event;
use Cake\ORM\Query;
use \ArrayObject;


class EventsTable extends Table
{
    

    public function beforeFind(Event $event, Query $query, ArrayObject $options)
    {
        $query->formatResults(function($results)
        {
            return $results->map(function($row)
            {
                if(isset($row['img']))
                {
                    $row['img'] = "data:image/jpeg;base64,".base64_encode(stream_get_contents($row['img']));
                    
                }
                return $row;
            });
        });
    }
}


?>