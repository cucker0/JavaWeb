文件上传和下载
==

## 

## 文件上传、下载
* 依赖jar包
```text
commons-fileupload.jar
commons-io.jar

https://commons.apache.org/proper/commons-fileupload/
http://commons.apache.org/proper/commons-io/
```


* form表单enctype="application/x-www-form-urlencoded"提交过来的数据
```text
POST / HTTP/1.1
Host: 127.0.0.1
Connection: keep-alive
Content-Length: 30443
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
Origin: http://localhost:8080
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: cross-site
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: http://localhost:8080/file/upload.html
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9

username=admin&passwrod=pw123456&file=%E5%A4%B4%E5%83%8F01.png
```

* form表单enctype="multipart/form-data"提交过来的数据
```text
POST / HTTP/1.1
Host: 127.0.0.1
Connection: keep-alive
Content-Length: 30443
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
Origin: http://localhost:8080
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryjoEWO9I66SQ9rs0d
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: cross-site
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: http://localhost:8080/file/upload.html
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9

------WebKitFormBoundaryjoEWO9I66SQ9rs0d
Content-Disposition: form-data; name="username"

admin
------WebKitFormBoundaryjoEWO9I66SQ9rs0d
Content-Disposition: form-data; name="passwrod"

pw123456
------WebKitFormBoundaryjoEWO9I66SQ9rs0d
Content-Disposition: form-data; name="file"; filename="头像01.png"
Content-Type: image/png

�PNG

   
IHDR   �      �    IDATx���g�l�q%�ǔm�}����#H���P$'F�B��!*�A�U�DMP#�H� �ó��mW]��Z�yή��H֍��]昽sg�\iv����/��r)�\�����?�������p*ggg�����>�GY.ruu#��Z���no���Z���L����XF��I����_��d����2}���Q��C988������`��}��Od��XoV2��d<ʣG���@����F��P~��_ȳ�Od2�������Ϟ^Ȳ�N&rvz*{{{<��Ņ<{���������e�^�5<�Zs��x�u�G��|��c"c��񰔁��H��(J���wʂǨk���O��k�׍��"US��Ҭ*Y��+�N�C�����^��^3^�ϲ,yO��W޿�i�x�F#~������Ҿ�_�t��T�nW��I�l�:�#O�RU)���f>����6WWr�O�~���	�˱����!ӛ����ܪ�
U8Fz\8��W_�'��{7������#ٟ�e2*�{+y�������J���T>�ݧ*�3�{��(U(�2�Ny����|�܃��,�^U:	�Ֆ��pd�R|?��݌�^/��^�^�~x��0�cb�p/6����s|�>+�`i9s�lsSW|����Fr=n�Xe&!8n\_�:�1��{I���l���y��~<�����E���"U8
]���~�X,�EJ���PW0$W-R���*��2��\�������ȱZ((�
... ...
�Wov��MP���s_��WW�8�T�A�y���<y��&�\[��v�͉� 0���S��[(���z��.��u t�z�ɹ.l�Q{��kY^]��}2��7��r��B�
�s�����'l(E2��XHo0J`��u������^����G�If2��ĶhIH�B�����T���N�|�YS�6BO�z\�����A��##/�e9�R�!1Ls�qE1���cL�'��>��ӊ>�#�R�gmް�Ф� ��%�_�C�Փ55���]>�����W���B��ݹ     IEND�B`�
------WebKitFormBoundaryjoEWO9I66SQ9rs0d--


```

* Servlet获取输入流，打印数据

    只输入了request body中的数据
    ```text
    public class UploadServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ServletInputStream inputStream = request.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            System.out.println(new String(bytes));
        }
    }
    ```
```text
------WebKitFormBoundaryjoEWO9I66SQ9rs0d
Content-Disposition: form-data; name="username"

admin
------WebKitFormBoundaryjoEWO9I66SQ9rs0d
Content-Disposition: form-data; name="passwrod"

pw123456
------WebKitFormBoundaryjoEWO9I66SQ9rs0d
Content-Disposition: form-data; name="file"; filename="头像01.png"
Content-Type: image/png

�PNG

   
IHDR   �      �    IDATx���g�l�q%�ǔm�}����#H���P$'F�B��!*�A�U�DMP#�H� �ó��mW]��Z�yή��H֍��]昽sg�\iv����/��r)�\�����?�������p*ggg�����>�GY.ruu#��Z���no���Z���L����XF��I����_��d����2}���Q��C988������`��}��Od��XoV2��d<ʣG���@����F��P~��_ȳ�Od2�������Ϟ^Ȳ�N&rvz*{{{<��Ņ<{���������e�^�5<�Zs��x�u�G��|��c"c��񰔁��H��(J���wʂǨk���O��k�׍��"US��Ҭ*Y��+�N�C�����^��^3^�ϲ,yO��W޿�i�x�F#~������Ҿ�_�t��T�nW��I�l�:�#O�RU)���f>����6WWr�O�~���	�˱����!ӛ����ܪ�
U8Fz\8��W_�'��{7������#ٟ�e2*�{+y�������J���T>�ݧ*�3�{��(U(�2�Ny����|�܃��,�^U:	�Ֆ��pd�R|?��݌�^/��^�^�~x��0�cb�p/6����s|�>+�`i9s�lsSW|����Fr=n�Xe&!8n\_�:�1��{I���l���y��~<�����E���"U8
]���~�X,�EJ���PW0$W-R���*��2��\�������ȱZ((�
... ...
�Wov��MP���s_��WW�8�T�A�y���<y��&�\[��v�͉� 0���S��[(���z��.��u t�z�ɹ.l�Q{��kY^]��}2��7��r��B�
�s�����'l(E2��XHo0J`��u������^����G�If2��ĶhIH�B�����T���N�|�YS�6BO�z\�����A��##/�e9�R�!1Ls�qE1���cL�'��>��ӊ>�#�R�gmް�Ф� ��%�_�C�Փ55���]>�����W���B��ݹ     IEND�B`�
------WebKitFormBoundaryjoEWO9I66SQ9rs0d--
```