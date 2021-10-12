import {Person} from "../person/person";

export abstract class Document {

  id: string;
  name: string;
  text: string;
  registrationNumber: number;
  dateOfRegistration: Date;
  author: Person;

  protected constructor(id: string,
                        name: string,
                        text: string,
                        registrationNumber: number,
                        dateOfRegistration: Date,
                        author: Person) {
    this.id = id;
    this.name = name;
    this.text = text;
    this.registrationNumber = registrationNumber;
    this.dateOfRegistration = dateOfRegistration;
    this.author = author;
  }
}
