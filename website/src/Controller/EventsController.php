<?php
    namespace App\Controller;
    use App\Controller\AppController;
    class EventsController extends AppController
    {
    
        public function index()
        {
            $this->set('events', $this->Events->find('all'));
            
        }
        
        public function detail($id = Null)
        {
            
            $event = $this->Events->get($id);
            
            $this->set('event', $event);
        }
        
        public function category($type)
        {
            $resultsArray = $this->Events
            ->find()
            ->where(['type =' => $type])
            ->toList();
            
            $this->set('events', $resultsArray);
        }
        
    }

?>