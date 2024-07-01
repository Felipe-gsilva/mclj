<script lang="ts">
  let result: String 
  let id: number

  async function postRequest () {
    const res = await fetch('http://0.0.0.0:8000/task/'+{id}, {
			method: 'DELETE'
    })

    const json = await res.json()
		result = JSON.stringify(json)
  }
</script>

<input bind:value={id} />
<button on:click={postRequest}>
  post the info
</button>

<pre>
  {result}
</pre>
