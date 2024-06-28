<script lang="ts">
  let result: String 

  async function getRequest () {
    const res = await fetch('http://0.0.0.0:8000/list-tasks', {
			method: 'GET'
    })

    const json = await res.json()
		result = JSON.stringify(json)
  }
</script>

<p> body: </p>
<pre>
  {result}
</pre>
<button on:click={getRequest}>
  send request
</button>
