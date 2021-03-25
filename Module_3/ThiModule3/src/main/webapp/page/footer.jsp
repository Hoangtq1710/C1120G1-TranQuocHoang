<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="jumbotron text-center" style="margin-bottom:0">
    <footer class="text-center text-dark" >
        <div class="container p-4 pb-0" style="background-color: #e9ecef">
            <section class="mb-4">
                <a
                        class="btn btn-success btn-floating m-1"
                        style="background-color: #3b5998;"
                        href="https://www.facebook.com/"
                        role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <a
                        class="btn btn-success btn-floating m-1"
                        style="background-color: #55acee;"
                        href="https://twitter.com/"
                        role="button"
                ><i class="fab fa-twitter"></i
                ></a>

                <a
                        class="btn btn-success btn-floating m-1"
                        style="background-color: #dd4b39;"
                        href="https://www.google.com/"
                        role="button"
                ><i class="fab fa-google"></i
                ></a>

                <a
                        class="btn btn-success btn-floating m-1"
                        style="background-color: #ac2bac;"
                        href="https://www.instagram.com/"
                        role="button"
                ><i class="fab fa-instagram"></i
                ></a>

                <a
                        class="btn btn-success btn-floating m-1"
                        style="background-color: #0082ca;"
                        href="https://www.linkedin.com/"
                        role="button"
                ><i class="fab fa-linkedin-in"></i
                ></a>

                <a
                        class="btn btn-success btn-floating m-1"
                        style="background-color: #333333;"
                        href="https://github.com/"
                        role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>

        </div>

        <div class="text-center p-3" style="background-color: #8fd19e">
            © 2021 Copyright:
            <a class="text-white" href="home" style="text-decoration: none">SOREN SHAW</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>

<script src="../assert/style/jquery/jquery-3.5.1.min.js"></script>
<script src="../assert/style/bootstrap/js/popper.min.js"></script>
<script src="../assert/style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assert/style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../assert/style/bootstrap/js/bootstrap.min.js"></script>
<script src="../assert/style/bootstrap/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#room').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6
        })
    })
</script>
<script>

    function saveIdDelete(idRoom, nameCustomer) {
        document.getElementById("idDeleteRoom").value = idRoom;
        document.getElementById("modelId").value = "Do you want to delete Room : "+ idRoom;
    }

    function submitFormDelete() {
        document.getElementById("formDelete").submit();
    }

</script>
<script type="text/javascript">
    function myFunction(messageName,messagePhone,messageDescription) {    //bao nhiêu message thi bấy nhiêu tham số
        if (messageName || messagePhone || messageDescription) { // tức là nếu bất kỳ message nào khác null thì sẽ bật modal lên lại
            $('#createRoom').modal('show');      //phương thức show modal
        }
    }
</script>

</body>
</html>