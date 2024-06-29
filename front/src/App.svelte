<script lang="ts">
  import List from './lib/List.svelte'
  import Create from './lib/Create.svelte'
  import Delete from './lib/Delete.svelte'
  import DeleteAll from './lib/DeleteAll.svelte'

</script>

<main>

  <div class="show">
    <h1> TaskList and mocking test </h1>
    <List />
    <br>
    <Create />
    <br>
    <Delete />
    <br>
    <DeleteAll />
  </div>


</main>

<style>
</style>
