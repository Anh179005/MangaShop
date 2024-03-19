<%-- 
    Document   : deposit
    Created on : Nov 10, 2023, 10:36:29 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nạp tiền</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Nạp tiền vào tài khoản</h3>
                    </div>
                    <div class="card-body">
                        <form method="post" action="deposit">
                            <div class="mb-3">
                                <label for="amount" class="form-label">Số tiền:</label>
                                <input type="number" class="form-control" id="amount" name="incAmount" placeholder="Nhập số tiền cần nạp" required>
                            </div>
                            <div>${requestScope.error}</div>
                            <button type="submit" class="btn btn-primary btn-block">Nạp tiền</button>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
