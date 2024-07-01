<script lang="ts">
  let result: String 

  async function getRequest () {
    const res = await fetch('http://0.0.0.0:8000/tasks', {
			method: 'GET'
    })

    const json = await res.json()
		result = JSON.stringify(json)
  }
</script>

<button on:click={getRequest}>
  send request
</button>
<pre>
  {result}
</pre>
