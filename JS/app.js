$(document).ready(function () {

    var addBook = $('#addBook');
    var findBook = $('#findBook');
    var findAllBooks = $('#findAllBooks');
    var button3 = $('.buttonNew')

    addBook.on('click', function () {

        var title = $('#title').val();
        var isbn = $('#isbn').val();
        var authorID = $('#authorID').val();
        var publisher = $('#publisher').val();
        var type = $('#type').val();

        $.ajax({
            url: 'http://localhost:8080/books/',
            type: 'POST',
            dataType: 'json',
            data:  JSON.stringify({"isbn": isbn, "title": title, "author": authorID, "publisher": publisher, "type": type}),
            success: function () {
            }
        });

    });


    findBook.on('click', function () {

        var id = $('#id').val()
        var book = $('#book')

        $.ajax({
            url: 'http://localhost:8080/books/' + id,
            type: 'GET',
            success: function (result) {
                var newLine = $('<p>')
                newLine.html("Title: " + result.title + ", Author: " + result.author.firstName + " " + result.author.lastName + ", Author's ID: " + result.author.id + ", Publisher: " + result.publisher + ", ISBN: " + result.isbn);
                book.append(newLine)
            }
        });
    });

    findAllBooks.on('click', function () {

        $.ajax({
            url: 'http://localhost:8080/books/',
            type: 'GET',
            success: function (result) {

                for (var i = 0; i < result.length; i++) {
                    var removeButton = $('<button class="removeButton" id=' + result[i].id + ' >');
                    removeButton.text('Delete');
                    $('#books').append("Title: " + result[i].title + ", Author: " + result[i].author.firstName + " " + result[i].author.lastName + ", Author's ID: " + result[i].author.id + ", Publisher: " + result[i].publisher + ", ISBN: " + result[i].isbn).append(removeButton).append('<br>');
                }
            }
        });
    });


    $('#books').on('click', '.removeButton', function(event){
        event.preventDefault();
        $.ajax({
            url: 'http://localhost:8080/books/'+$(this).attr('id'),
            dataType: 'json',
            type: 'delete',
        });
    });




});
