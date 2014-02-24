//This tells the window to wait for everything to load before starting to run the javascript
$(init);
//Checkout form validation rules
    var customerRules=
	{
		firstName:				
		{
			required: true
		},
		lastName:
		{
			required: true			
		},
		email:
		{
			required: true			
		},
		phone:
		{
			required: true,		
                        digits:true
		},
                street:
                {
                        required:true
                },
                city:
                {
                        required:true
                },
                state:
                {
                        required:true
                },
		creditCardNumber:
		{
			required: true,			
			digits: true
		}
	};
//Checkout form validation messages 
	var customerMessages = 
	{
		firstName:				
		{
			required: "You must enter your first name"
		},
		lastName:
		{
			required: "You must enter your last name"			
		},
		email:
		{
			required: "You must provide an e-mail address"		
		},
		phone:
		{
			required: "Please provide your phone number",	
                        digits:"Invalid number"
		},
                street:
                {
                        required:"You must eneter your street address"
                },
                city:
                {
                        required:"City is required"
                },
                state:
                {
                        required:"State is required"
                },
		creditCardNumber:
		{
			required: "Please enter your credi card number",	
			digits: "Invalid card number"
		}
	};

//Checkout Event is defined here
	var addCustomerEvent =
	{
		submitHandler: addCustomer,	
		rules: customerRules,					
		messages: customerMessages			
	};


//Ensures that the proper form is validated with the corresponding event
	$("#addCustomer").validate(addCustomerEvent);
