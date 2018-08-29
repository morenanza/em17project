<!-- src/Template/Users/add.ctp -->

<div class="users form">
<?= $this->Form->create($user) ?>
    <fieldset>
        <legend><?= __('Registrati') ?></legend>
        <?= $this->Form->control('username') ?>
        <?= $this->Form->control('password') ?>
        <?= $this->Form->control('email') ?>
        <?= $this->Form->control('name') ?>
        <?= $this->Form->control('surname') ?>
        <?= $this->Form->control('address') ?>
        <?= $this->Form->control('cap') ?>
        <?= $this->Form->control('city') ?>
        <?= $this->Form->control('province') ?>
        <?= $this->Form->control('date') ?>
   </fieldset>
<?= $this->Form->button(__('Registrati')); ?>
<?= $this->Form->end() ?>
</div>