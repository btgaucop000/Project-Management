var chartDataStr = decodeHtml(chartData);
var chartJsonArr = JSON.parse(chartDataStr);

var arrLength = chartJsonArr.length;
var numericData = [];
var labelData = []; 

for (var index = 0; index < arrLength; index++) {
    numericData[index] = chartJsonArr[index].value;
    labelData[index] = chartJsonArr[index].label;
}
new Chart(document.getElementById('myPieChart'), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: '# of Votes',
            data: numericData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
            ],
            borderWidth: 1
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

function decodeHtml(html) {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}