import React, { useState } from "react";
import EmployeeService from "../services/EmployeeService";
import { Link, useHistory } from "react-router-dom";

const AddEmployeeComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [emailId, setEmailId] = useState("");
  const history = useHistory();

  const saveEmployee = (e) => {
    e.preventDefault();
    const employee = { firstName, lastName, emailId };
    EmployeeService.createEmployee(employee)
      .then((response) => {
        console.log(response.data);
        history.push("/employees");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h2 className="text-center">Add Employee</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">First Name : </label>
                  <input
                    type="text"
                    placeholder="Enter first name"
                    name="firstName"
                    className="form-control"
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                  />
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Last Name : </label>
                  <input
                    type="text"
                    placeholder="Enter last name"
                    name="lastName"
                    className="form-control"
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                  />
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">Email Id : </label>
                  <input
                    type="email"
                    placeholder="Enter Your Email Id"
                    name="emailId"
                    className="form-control"
                    value={emailId}
                    onChange={(e) => setEmailId(e.target.value)}
                  />
                </div>
                <div>
                  <button
                    className="btn btn-success"
                    onClick={(e) => saveEmployee(e)}
                  >
                    Submit
                  </button>
                  <Link to="/employees" className="btn btn-danger">
                    Cancel
                  </Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddEmployeeComponent;
