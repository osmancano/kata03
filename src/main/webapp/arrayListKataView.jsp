<script>
    $('.btnArrayListFunction').click(function(event) { // catch the form's submit event
        event.preventDefault();
        var ArrayList = $("#myArrayList").val();
        if(ArrayList == null || ArrayList ==""){
            alert("Array List must not be empty");
            return false;
        }
        $.post(this.href,{ arrayList: ArrayList},function (response) {
            $("#resultDiv").html(response)
        })
        return false; // cancel original event to prevent form submitting
    });
</script>
<br>
<div>

    <h4>Array List Kata:</h4>

    <label class="control-label" for="myArrayList">Enter Your ArrayList elements comma separated:</label>
    <div>
        <input type="text" class="form-control" id="myArrayList" name="myArrayList" placeholder="Enter your Array List" required/>
    </div>
    <hr/>
    <a href="/kata03/arraylist/1/" class="btnArrayListFunction btn btn-sm btn-primary">First Last Six</a>&nbsp;
    <a href="/kata03/arraylist/2/" class="btnArrayListFunction btn btn-sm btn-primary">Same First Last</a>&nbsp;
    <a href="/kata03/arraylist/3/" class="btnArrayListFunction btn btn-sm btn-primary">Rotate Left 3</a>
    <a href="/kata03/arraylist/4/" class="btnArrayListFunction btn btn-sm btn-primary">Reverse 3</a>
    <a href="/kata03/arraylist/5/" class="btnArrayListFunction btn btn-sm btn-primary">Sum First Penultimate</a>

    <hr/>
    <div id="resultDiv">

    </div>

</div>
