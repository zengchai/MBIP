const ctx = document.getElementById('acquisitions');
  new Chart( ctx ,
    {
      type: 'doughnut',
      data: {
        labels: ['Water', 'Electricity', 'Recycling'],
        datasets: [
          {
            label: 'Acquisitions by year',
            data: [waterConsump, elecConsump, recycleConsump]
          }
        ]
      }
    }
  );