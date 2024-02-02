const ctx = document.getElementById('acquisitions');

ctx.width = ctx.parentElement.clientWidth;
ctx.height = ctx.parentElement.clientHeight;

const formattedWaterConsump = parseFloat(waterConsump * 0.419).toFixed(2);
const formattedElecConsump = parseFloat(elecConsump * 0.548).toFixed(2);
const formattedRecycleConsump = parseFloat(recycleConsump * 2.860).toFixed(2);

new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Water', 'Electricity', 'Recycling'],
        datasets: [{
            label: 'Carbon reduction value',
            data: [
                formattedWaterConsump,
                formattedElecConsump,
                formattedRecycleConsump
            ]
        }]
    }
});
