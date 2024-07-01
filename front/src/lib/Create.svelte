<script lang="ts">
  let result: String 
  let desc: String 
  let stat: String

  async function postRequest () {
    const res = await fetch('http://0.0.0.0:8000/tasks', {
			method: 'POST',
      body: JSON.stringify({
        desc,
        stat
      })
    })

    const json = await res.json()
		result = JSON.stringify(json)
  }
</script>

<input bind:value={desc} />
<input bind:value={stat} />
<button on:click={postRequest}>
  post the info
</button>

<pre>
  {result}
</pre>
