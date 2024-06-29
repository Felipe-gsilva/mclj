<script lang="ts">
  let result: String 

  async function postRequest () {
    const res = await fetch('http://0.0.0.0:8000/delete-all', {
			method: 'DELETE'
    })

    const json = await res.json()
		result = JSON.stringify(json)
  }
</script>

<button on:click={postRequest}>
  delete all 
</button>

<pre>
  {result}
</pre>
