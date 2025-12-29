document.addEventListener("DOMContentLoaded", () => {

    const modal = document.getElementById("deleteModal");
    const confirmBtn = document.getElementById("confirmDelete");
    const cancelBtn = document.getElementById("cancelDelete");
    const message = document.getElementById("deleteMessage");
    const title = modal.querySelector("h3");

    let formToSubmit = null;

    document.querySelectorAll(".icon.delete").forEach(button => {
        button.addEventListener("click", () => {

            formToSubmit = button.closest("form");
            const userId = button.getAttribute("data-id");

            title.textContent = "Confirm Deletion";
            message.textContent = `Do you really want to delete user #${userId}?`;

            if (confirmBtn) {
                confirmBtn.classList.remove("hidden"); 
            }

            modal.classList.add("show");
        });
    });

    if (confirmBtn) {
        confirmBtn.addEventListener("click", () => {
            if (formToSubmit) {
                formToSubmit.submit();
            }
        });
    }
	
    cancelBtn.addEventListener("click", () => {
        closeModal();
    });

    function closeModal() {
        modal.classList.remove("show");
        formToSubmit = null;
        message.textContent = "";
    }
});
