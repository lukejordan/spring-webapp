


<%@ include file="include/header.jspf"%>

<div class="main-body">
	<h1>Test App</h1>
	<p>This is a test angular app.</p>



	<div ng-app="invoice1" ng-controller="InvoiceController as invoice">
		<b>Invoice:</b>
		<div>
			Quantity: <input type="number" min="0" ng-model="invoice.qty"
				required>
		</div>
		<div>
			Costs: <input type="number" min="0" ng-model="invoice.cost" required>
			<select ng-model="invoice.inCurr">
				<option ng-repeat="c in invoice.currencies">{{c}}</option>
			</select>
		</div>
		<div>
			<b>Total:</b> <span ng-repeat="c in invoice.currencies">
				{{invoice.total(c) | currency:c}} </span>
			<button class="btn" ng-click="invoice.pay()">Pay</button>
		</div>
	</div>



</div>

<%@ include file="include/footer.jspf"%>