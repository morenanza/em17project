<?php
if (!isset($params['escape']) || $params['escape'] !== false) {
    $message = h($message);
}
?>
<div class="row" style="margin-left:0px; margin-right:0px;">
<div class="col-md-4"></div><div class="message error col-md-4" onclick="this.classList.add('hidden');"><p align="center"><?= $message ?></div><div class="col-md-4"></p></div>
<!--<div class="col-md-4"></div>--></div>
