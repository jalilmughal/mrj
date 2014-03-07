<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Customer</title>
    <style>
      label {display: inline; width: 8em; text-align: left; float: left;}
      fieldset {width: 20em;padding: 1em;}
    </style>
  </head>
  <body>
    <h1>Add customer</h1>
    <p>This page should be visible for SuperEmployees only</p>
    <fieldset>
      <legend>Customer Details</legend>
      <Form>
        <div>
          <div><label for="cpr">Cpr</label><input type="text" name="cpr" id="cpr" required/></div>
          <div><label for="title">Title</label><input type="text" name="title" id="title" required/></div>
          <div><label for="firstName">First Name</label><input type="text" name="firstName" id="firstName" required/></div>
          <div><label for="lastName">Last Name</label><input type="text" name="lastName" id="lastName" required/></div>
          <div><label for="street">Street</label><input type="text" name="street" id="street" required/></div>
          <div><label for="postalCode">Postal Code</label><input type="text" name="postalCode" id="postalCode" required/></div>
          <div><label for="postalDistrict">Postal District</label><input type="text" name="postalDistrict" id="postalDistrict" required/></div>
          <div><label for="phone">Phone</label><input type="text" name="phone" id="phone" required/></div>
          <div><label for="email">Email</label><input type="email" name="email" id="email"/></div>
        </div>
        <input type="hidden" name="command" value="save-customer">
        <br/>
        <input type="submit" value="save"/>
      </Form>
    </fieldset>
    <br/>
    <ul >
      <li><a href="Controller?command=main">Back to main</a></li>
      <li><a href="Controller?command=list-customers">See all customers</a></li>
    </ul>
  </body>
</html>
