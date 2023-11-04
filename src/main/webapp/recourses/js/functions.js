function deleteStudents() {
    var idsToDelete = " "; // String 1 3 5 6 7
    var checkBoxes = document.getElementsByClassName('idStudent');


    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            idsToDelete = idsToDelete + checkBoxes[i].value + " ";
        }
    }

    if (idsToDelete == " ") {
        alert("Необходимо выбрать хотя бы одного студента");
        return;
    }

    var hidden = document.getElementById('hiddenDelete');
    hidden.value = idsToDelete;
    document.getElementById('formDelete').submit();

}
function modifyStudents() {
    var idsToModify = "";
    var checkBoxes = document.getElementsByClassName('idStudent');
    var countChekedChekBox =0;

    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            countChekedChekBox++;
            idsToModify = checkBoxes[i].value;
        }
    }

    if (countChekedChekBox == 0) {
        alert("Необходимо выбрать хотя бы одного студента");
        return;
    }

    if (countChekedChekBox > 1) {
        alert("Необходимо выбрать только одного студента");
        return;
    }

    var hidden = document.getElementById('hiddenModify');
    hidden.value = idsToModify;
    document.getElementById('formModify').submit();
}
function deleteDiscipline() {
    var idDDiscipline = " "; // String 1 3 5 6 7
    var checkBoxes = document.getElementsByClassName('idToDiscipline');


    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            idDDiscipline = idDDiscipline + checkBoxes[i].value + " ";
        }
    }

    if (idDDiscipline == " ") {
        alert("Необходимо выбрать хотя бы одного студента");
        return;
    }

    var hidden = document.getElementById('hiddenDeleteDiscipline');
    hidden.value = idDDiscipline;
    document.getElementById('formDeleteDiscipline').submit();
}
function progresStudents() {
    var idProgress = "";
    var checkBoxes = document.getElementsByClassName('idStudent');
    var countChekedChekBox = 0;

    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            countChekedChekBox++;
            idProgress = checkBoxes[i].value;
        }
    }

    if (countChekedChekBox == 0) {
        alert("Необходимо выбрать хотя бы одного студента");
        return;
    }

    if (countChekedChekBox > 1) {
        alert("Необходимо выбрать только одного студента");
        return;
    }
    var hidden = document.getElementById('hiddenProgress');
    hidden.value = idProgress;
    document.getElementById('formProgress').submit();
}
function modifyDiscipline() {
    var idsToModify = "";
    var checkBoxes = document.getElementsByClassName('idToDiscipline');
    var countChekedChekBox =0;

    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            countChekedChekBox++;
            idsToModify = checkBoxes[i].value;
        }
    }

    if (countChekedChekBox == 0) {
        alert("Необходимо выбрать хотя бы одного студента");
        return;
    }

    if (countChekedChekBox > 1) {
        alert("Необходимо выбрать только одного студента");
        return;
    }

    var hidden = document.getElementById('hiddenModifyDiscipline');
    hidden.value = idsToModify;
    document.getElementById('formModifyDiscipline').submit();
}