<script>
    $('.btnHashMapFunction').click(function(event) { // catch the form's submit event
        event.preventDefault();
        var HashMap = $("#myHashMap").val();
        if(HashMap == null || HashMap ==""){
            alert("Hash Map must not be empty");
            return false;
        }
        $.post(this.href,{ hashMap: HashMap},function (response) {
            $("#resultDiv").html(response)
        })
        return false; // cancel original event to prevent form submitting
    });
</script>
<br>
<div>

    <h4>Hash Map Kata:</h4>

    <label class="control-label" for="myHashMap">Enter Your Hash Map elements comma separated eg:[key1:value1,key2:value2] or a comma separated values for array list for the last two functions:</label>
    <div>
        <input type="text" class="form-control" id="myHashMap" name="myHashMap" placeholder="Enter your Hash Map" required/>
    </div>
    <hr/>
    <a href="/kata03/hashmap/1/" class="btnHashMapFunction btn btn-sm btn-primary">Map Bully</a>&nbsp;
    <a href="/kata03/hashmap/2/" class="btnHashMapFunction btn btn-sm btn-primary">Map Share</a>&nbsp;
    <a href="/kata03/hashmap/3/" class="btnHashMapFunction btn btn-sm btn-primary">Map AB</a>
    <a href="/kata03/hashmap/4/" class="btnHashMapFunction btn btn-sm btn-danger">Word Length</a>
    <a href="/kata03/hashmap/5/" class="btnHashMapFunction btn btn-sm btn-danger">Index Words</a>

    <hr/>
    <div id="resultDiv">

    </div>

</div>
