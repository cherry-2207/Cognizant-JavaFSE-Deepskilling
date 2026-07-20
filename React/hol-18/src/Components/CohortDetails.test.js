import React from "react";
import { render, screen } from "@testing-library/react";
import CohortDetails from "./CohortDetails";
import { CohortData } from "../Cohort";

describe("Cohort Details Component", () => {
  const mockCohort = CohortData[0];

  test("should create the component", () => {
    const { container } = render(<CohortDetails cohort={mockCohort} />);
    expect(container).toBeInTheDocument();
  });

  test("should initialize the props", () => {
    render(<CohortDetails cohort={mockCohort} />);
    // Check that props data (like Course Name, Students Count) are displayed
    expect(screen.getByText(mockCohort.name)).toBeInTheDocument();
    expect(screen.getByText(mockCohort.studentsCount.toString())).toBeInTheDocument();
  });

  test("should display cohort code in h3", () => {
    const { container } = render(<CohortDetails cohort={mockCohort} />);
    const h3Element = container.querySelector("h3");
    expect(h3Element).toBeInTheDocument();
    expect(h3Element.textContent).toBe(mockCohort.code);
  });

  test("should always render same html", () => {
    const { asFragment } = render(<CohortDetails cohort={mockCohort} />);
    expect(asFragment()).toMatchSnapshot();
  });
});
