<div class='sideBar-container'>

    <!-- 3-dot menu icon to toggle the sidebar -->
    <div class="menu-icon" onclick="toggleSidebarOver()">
        <i class="fas fa-ellipsis-v"></i>
    </div>

     <!-- Sidebar content -->
    <div class="sidebar-content">
        <div class="menu-tab">
            <h4>MENU</h4>
        </div>
        <a href="#" class="menu-button"><i class="fas fa-file-invoice" style="font-size: 2rem;"></i>&nbsp;&nbsp;Bills</a>
        <a href="#" class="menu-button"><i class="fas fa-trophy" style="font-size: 2rem;"></i>&nbsp;&nbsp;Competition</a>
        <a href="#" class="menu-button"><i class="fas fa-calendar-alt" style="font-size: 2rem;"></i>&nbsp;&nbsp;Timeline</a>
    </div>
</div>

<script>
    // JavaScript function to toggle the sidebar
    function toggleSidebarOver() {
        var sidebarContainer = document.querySelector('.sideBar-container');
        var mainContentContainer = document.querySelector('.main-content-container');

        sidebarContainer.classList.toggle('sidebar-hidden');
        mainContentContainer.classList.toggle('sidebar-hidden');
    }

</script>
