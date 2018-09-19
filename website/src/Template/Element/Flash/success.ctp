<?php
    if (!isset($params['escape']) || $params['escape'] !== false) {
        $message = h($message);
    if($message != null) {

?>  
    <div class="container" style="margin-top: 10px;">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <?= $message ?>
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                </div>
            </div>
        </div>
    </div>
<?php
    }
    }
?>

