<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>js签名</title>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/jq-signature.min.js"></script>
</head>
<body>
<div class="js-signature" data-width="600" data-height="200" data-border="1px solid black"
     data-line-color="#bc0000" data-auto-fit="true"></div>
<p>
    <button id="clearBtn" class="btn btn-default" onclick="clearCanvas();">Clear Canvas</button>
    &nbsp;
    <button
            id="saveBtn" class="btn btn-default" onclick="saveSignature();" disabled>Save Signature
    </button>
</p>
<div id="signature">
    <p><em>Your signature will appear here when you click "Save Signature"</em></p>
</div>

<form id="jsSignForm">
    <input type="hidden" name="imgData" id="imgData"/>
</form>


<script type="text/javascript">
    $(document).on('ready', function ()
    {
        if ($('.js-signature').length)
        {
            $('.js-signature').jqSignature();
        }
    });

    /*
    * Demo
    */
    function clearCanvas()
    {
        $('#signature').html(
                '<p><em>Your signature will appear here when you click "Save Signature"</em></p>');
        $('.js-signature').jqSignature('clearCanvas');
        $('#saveBtn').attr('disabled', true);
    }

    function saveSignature()
    {
        $('#signature').empty();
        var dataUrl = $('.js-signature').jqSignature('getDataURL');
        var img = $('<img>').attr('src', dataUrl);
        $('#signature').append($('<p>').text("Here's your signature:"));
        $('#signature').append(img);

        $('#imgData').val(dataUrl);
        $.ajax({
            url:'/jsSignSave',
            type:'post',
            data:$('#jsSignForm').serialize(),
            dataType:'json',
            success:function(data)
            {
                alert(data.message);

            },
            error:function(data)
            {
                alert(data.message);
            }
        })
    }

    $('.js-signature').on('jq.signature.changed', function ()
    {
        $('#saveBtn').attr('disabled', false);
    });
</script>
</body>
</html>