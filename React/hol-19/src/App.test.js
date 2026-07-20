import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Git Client App title', () => {
  render(<App />);
  const titleElement = screen.getByText(/Git Client App/i);
  expect(titleElement).toBeInTheDocument();
});
