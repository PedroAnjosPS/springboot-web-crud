document.addEventListener("DOMContentLoaded", () => {

	const modal = document.getElementById("deleteModal");
	const confirmBtn = document.getElementById("confirmDelete");
	const cancelBtn = document.getElementById("cancelDelete");
	const message = document.getElementById("deleteMessage");

	let formToSubmit = null;

	document.querySelectorAll(".icon.delete").forEach(button => {
		button.addEventListener("click", () => {

			formToSubmit = button.closest("form");

			const userId = button.getAttribute("data-id");
			message.textContent = `Do you really want to delete user #${userId}?`;

			modal.style.display = "flex";
		});
	});

	confirmBtn.addEventListener("click", () => {
		if (formToSubmit) {
			formToSubmit.submit();
		}
	});

	cancelBtn.addEventListener("click", () => {
		modal.style.display = "none";
		formToSubmit = null;
	});
});
