import {Person} from "../person/person";
import {Document} from "./document";

export class Task extends Document {

  dateOfIssue: Date;
  periodOfExecution: string;
  controlSign: boolean;
  executor: Person;
  controller: Person;

  constructor(id: string,
              name: string,
              text: string,
              registrationNumber: number,
              dateOfRegistration: Date,
              author: Person,
              dateOfIssue: Date,
              periodOfExecution: string,
              controlSign: boolean,
              executor: Person,
              controller: Person) {
    super(id, name, text, registrationNumber, dateOfRegistration, author);
    this.dateOfIssue = dateOfIssue;
    this.periodOfExecution = periodOfExecution;
    this.controlSign = controlSign;
    this.executor = executor;
    this.controller = controller;
  }
}
